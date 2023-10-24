package com.example.studentbot.services;

import com.example.studentbot.config.BotConfig;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Component
@AllArgsConstructor
public class TelegramBot extends TelegramLongPollingBot {
    private BotConfig botConfig;

    @Override
    public String getBotToken() {
        return botConfig.getToken();
    }

    @Override
    public String getBotUsername() {
        return botConfig.getBotName();
    }

    @Override
    public void onUpdateReceived(Update update) {
        try {
            if (update.hasMessage() && update.getMessage().hasText()) {
                String messageText = update.getMessage().getText().toLowerCase();
                Message message = update.getMessage();
                String text = "";
                switch (messageText) {
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
                    case "@all":
                        if (message.getChatId().toString().equals("-1001954492850")) {
                            text = "Я тут не работаю";
                        } else {
                            text = "@SOPAmashaallah " +
                                    "@knopsc " +
                                    "@alexandrerro " +
                                    "@Nikolai_math " +
                                    "@Ceppega " +
                                    "@Lorradane " +
                                    "@Bl4ck_d4rkness " +
                                    "@FeDDoSoff " +
                                    "@OlegSimkin " +
                                    "@des7ruct1on " +
                                    "@fieldspoke " +
                                    "@Evgenialnaja " +
                                    "@Isag_brI " +
                                    "@dissembler09 " +
                                    "@Che4ve " +
                                    "@yoonseak " +
                                    "@Pe1men " +
                                    "@DaMilo1a " +
                                    "@teslichanskiy " +
                                    "@ZhukovHandG " +
                                    "@whfall " +
                                    "@dictuter " +
                                    "@HACPAHO228 " +
                                    "@akghh " +
                                    "@Drosenber";
                        }
                        break;
                    case "/никита":
                        Thread NIKITA = new Thread() {
                            @Override
                            public void run() {
                                for (int i = 0; i < 99; i++) {
                                    sendMessage(message, "НИКИТА");
                                }
                            }
                        };
                        NIKITA.start();
                        break;
                    case "/алина":
                        text = "Любовь";
                        break;
                    case "/назим":
                        text = "ЧИЧ";
                        break;
                    case "/фёдор":
                        text = "Хуёдор";
                        break;
                    default:
                        if (messageText.endsWith("да")) {
                            text = "ПИЗДА!";
                        } else {
                            return;
                        }
                        break;
                }
                sendMessage(message, text);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void sendMessage(Message message, String textToSend) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(message.getChatId());
        if (message.isTopicMessage()) {
            sendMessage.setMessageThreadId(message.getMessageThreadId());
        }
        sendMessage.setText(textToSend);
        try {
            execute(sendMessage);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
