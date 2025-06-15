import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ChatBotGUI extends JFrame {
    private JTextArea chatArea;
    private JTextField inputField;
    private JButton sendButton;

    public ChatBotGUI() {
        setTitle("Java Chatbot");
        setSize(400, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Chat display area
        chatArea = new JTextArea();
        chatArea.setEditable(false);
        chatArea.setFont(new Font("Arial", Font.PLAIN, 14));
        JScrollPane scrollPane = new JScrollPane(chatArea);
        add(scrollPane, BorderLayout.CENTER);

        // Input panel
        JPanel inputPanel = new JPanel(new BorderLayout());
        inputField = new JTextField();
        sendButton = new JButton("Send");

        inputPanel.add(inputField, BorderLayout.CENTER);
        inputPanel.add(sendButton, BorderLayout.EAST);

        add(inputPanel, BorderLayout.SOUTH);

        // Action for send
        sendButton.addActionListener(e -> sendMessage());
        inputField.addActionListener(e -> sendMessage());
    }

    private void sendMessage() {
        String userText = inputField.getText().trim();
        if (userText.isEmpty()) return;

        chatArea.append("You: " + userText + "\n");
        String botReply = getBotResponse(userText);
        chatArea.append("Bot: " + botReply + "\n\n");
        inputField.setText("");
    }

    // Simple rule-based bot response
    private String getBotResponse(String input) {
        input = input.toLowerCase();
        if (input.contains("hello") || input.contains("hi")) return "Hello! How can I assist you?";
        if (input.contains("book room")) return "Sure! Please tell me the room type and dates.";
        if (input.contains("bye")) return "Goodbye! Have a great day!";
        if (input.contains("thanks")) return "You're welcome!";
        return "I'm not sure how to respond to that.";
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ChatBotGUI chatBot = new ChatBotGUI();
            chatBot.setVisible(true);
        });
    }
}
