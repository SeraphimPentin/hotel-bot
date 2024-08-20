package sim.commands;

public class NonCommand {

    /**
     * Обработка сообщения, не являющегося командой (т.е. обычного текста не начинающегося с "/")
     */

    public String nonCommandExecute(Long chatId, String userName, String text) {
        String answer;
        try {


            answer = "Настройки обновлены. Вы всегда можете их посмотреть с помощью /settings";
            //логируем событие, используя userName
        } catch (IllegalArgumentException e) {
            answer = e.getMessage() +
                    "\n\n Настройки не были изменены. Вы всегда можете их посмотреть с помощью /settings";
            //логируем событие, используя userName
        } catch (Exception e) {
            answer = "Простите, я не понимаю Вас. Возможно, Вам поможет /help";
            //логируем событие, используя userName
        }
        return answer;
    }

    private String answer(String text) throws IllegalArgumentException {
        if (text == null) {
            throw new IllegalArgumentException("Сообщение не является текстом");
        }
        return "Не понял.";
    }

}
