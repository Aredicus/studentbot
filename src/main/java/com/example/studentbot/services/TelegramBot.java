package com.example.studentbot.services;

import com.example.studentbot.config.BotConfig;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.Objects;


@Component
@AllArgsConstructor
public class TelegramBot extends TelegramLongPollingBot {
    private BotConfig botConfig;

    @Override
    public String getBotUsername() {
        return botConfig.getBotName();
    }

    @Override
    public void onUpdateReceived(Update update) {
        try {
            if (update.hasMessage() && update.getMessage().hasText()) {
                Message message = update.getMessage();
                String messageText = message.getText().toLowerCase();
                String text = answer(messageText, message.getChatId());
                if (Objects.isNull(text) || text.isEmpty()) {
                    return;
                }
                sendMessage(message, text);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void sendMessage(Message message, String textToSend) {
        SendMessage sendMessage = SendMessage.builder()
                .chatId(message.getChatId())
                .messageThreadId(message.getMessageThreadId())
                .text(textToSend)
                .build();
        try {
            execute(sendMessage);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private String answer(String question, Long chatId) {
        String text = "";
        switch (question) {
            case "/start":
                text = "/TPR - ссылка на гугл класс\n/OOP - ссылка на диск для загрузки лаб и кп\n/OLEG - ссылка на класс для ОЛЕГА";
                break;
            case "/tpr":
                text = "https://classroom.google.com/c/NTc3ODU3NDExODI5?cjc=c5vme6o";
                break;
            case "/oop":
                text = "https://drive.google.com/drive/folders/1HnMZIo8acPIxKuX_aZ-RrNET-1IsRA2F";
                break;
            case "/oleg":
                text = "https://classroom.google.com/c/NjI2MjQyMzM0MTc3?cjc=t3usrhb\n@OlegSimkin ";
                break;
            case "да":
                text = "Пизда";
                break;
            case "нет":
                text = "Пидора ответ";
                break;
            case "говно":
                text = "...залупа, пенис, хер, давалка, хуй, блядина, головка, шлюха, жопа, член, еблан, петух, мудила, рукоблуд, ссанина, очко, блядун, вагина, сука, ебланище, влагалище, пердун, дрочила, пидор, пизда, туз, малафья, гомик, мудила, пилотка, манда, анус, вагина, путана, педрила, шалава, хуила, мошонка, елда";
                break;
            case "а":
                text = "Хуй на";
                break;
            case "300":
                text = "Отсоси у тракториста";
                break;
            case "валя":
                text = "Прекрасная";
                break;
            case "пизда":
                text = "Дохуя умный, да?";
                break;
            case "дохуя умный, да?":
                text = "Да";
                break;
            case "ладно":
                text = "Прохладно";
                break;
            case "иди на хуй":
                text = "Сам пиздуй";
                break;
            case "/назим":
                text = "ЧИЧ";
                break;
            default:
                if (question.endsWith("да")) {
                    text = "ПИЗДА!";
                } else {
                    return text;
                }
                break;
        }
        return text;
    }
}
