package sim.commands;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.bots.AbsSender;
import sim.Utils;

import java.nio.charset.StandardCharsets;

/**
 * Команда "Помощь"
 */
public class HelpCommand extends ServiceCommand {
    private Logger logger = LoggerFactory.getLogger(HelpCommand.class);

    public HelpCommand(String identifier, String description) {
        super(identifier, description);
    }

    @Override
    public void execute(AbsSender absSender, User user, Chat chat, String[] strings) {
        String userName = Utils.getUserName(user);

        String answer = "Я бот, который поможет вести вам учет посетителей гостинцы\n\n" +
                "Вам нужно их зарегистрировать с помощью бота \n\n " +
                "А все записи о посетителях будут хранится в Exel табице." +
                "❗*Список команд*\n" +
                "/help - помощь\n\n" +
                "Желаю удачи\uD83D\uDE42";

        byte[] utf8Bytes = answer.getBytes(StandardCharsets.UTF_8);
        String utf8answer = new String(utf8Bytes, StandardCharsets.UTF_8);

        logger.debug(String.format("Пользователь %s. Начато выполнение команды %s", userName,
                this.getCommandIdentifier()));
        sendAnswer(absSender, chat.getId(), this.getCommandIdentifier(), userName, utf8answer);
        logger.debug(String.format("Пользователь %s. Завершено выполнение команды %s", userName,
                this.getCommandIdentifier()));
    }
}