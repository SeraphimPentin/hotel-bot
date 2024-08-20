package sim.bot;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.extensions.bots.commandbot.TelegramLongPollingCommandBot;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.Message;
import sim.commands.StartCommand;
import sim.commands.HelpCommand;


import java.util.List;

@Component
public class Bot extends TelegramLongPollingCommandBot {

    private static final Logger LOGGER = LoggerFactory.getLogger(Bot.class);
    private static final String DEBUG_INFO_TEXT = "Update from ";


    private final String botName;
    private final String botToken;

//    @Autowired
//    private Collection<IBotCommand> commands;

    @Autowired
    public Bot(
            @Value("${bot.name}") String botName,
            @Value("${bot.token}") String botToken
    ) {
        super();
        this.botName = botName;
        this.botToken = botToken;

        //регистрируем команды
        register(new StartCommand("start", "Старт"));
        register(new HelpCommand("help","Помощь"));
    }


    public Bot(DefaultBotOptions options, boolean allowCommandsWithUsername, String botName, String botToken) {
        super(options, allowCommandsWithUsername);
        this.botName = botName;
        this.botToken = botToken;
    }

    @Override
    public String getBotUsername() {
        return botName;
    }

    @Override
    public String getBotToken() {
        return botToken;
    }

    @Override
    public void onRegister() {
        super.onRegister();
//        for (IBotCommand command : commands) {
//            register(command);
//        }
    }

    @Override
    public void processNonCommandUpdate(Update update) {
        if (LOGGER.isDebugEnabled()) {
            String s = messageDebugInfo(update.getMessage());
            LOGGER.debug(s);
        }
    }

    @Override
    public void onUpdatesReceived(List<Update> updates) {
        super.onUpdatesReceived(updates);

    }


    private static String messageDebugInfo(Message message) {
        if (message == null) {
            return "Null message";
        }
        String debugInfo = new ReflectionToStringBuilder(message).toString();
        return DEBUG_INFO_TEXT + message.getChatId() + "\n" + debugInfo;
    }


}
