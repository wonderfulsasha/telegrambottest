
import org.telegram.telegrambots.bots.TelegramLongPollingBot;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;


public class Bot extends TelegramLongPollingBot {
    public static void main(String[] args) {

        try {
            TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
            botsApi.registerBot(new Bot());
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
    @Override
    public String getBotUsername () {
        return "@hotelSPB";
    }

    @Override
    public String getBotToken () {
        return " ***TOKEN*** ";
    }

    @Override
    public void onUpdateReceived (Update update) {
        update.getUpdateId();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/uuuu");
        LocalDate localDate = LocalDate.now();
        SendMessage outMessage = new SendMessage();


        if (update.hasMessage() && "/заселение".equals(update.getMessage().getText())){
            try{
                outMessage.setChatId(update.getMessage().getChatId().toString());
                outMessage.setText("На момент " + dtf.format(localDate) +   " для заселения нужно: ... ");
                execute(outMessage);
            }
            catch (TelegramApiException e){
                e.printStackTrace();
            }
            } else if (update.hasMessage() && "/услуги".equals(update.getMessage().getText())) {
                try {
                    outMessage.setChatId(update.getMessage().getChatId().toString());
                    outMessage.setText("Из услуг доступно: ...");
                    execute(outMessage);
                } catch (TelegramApiException e){
                    e.printStackTrace();
                }
        } else if (update.hasMessage() && "/фотокота".equals(update.getMessage().getText())) {
            try {
                outMessage.setChatId(update.getMessage().getChatId().toString());
                outMessage.setText("test123");
                execute(outMessage);

            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
        }

    }
