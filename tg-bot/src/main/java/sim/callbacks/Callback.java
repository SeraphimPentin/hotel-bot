package sim.callbacks;

import java.io.Serializable;

/**
 * В общем смысле Callback - это любая текстовая информация, не являющаяся командой,
 * что может прийти на сервер в результате взаимодействия пользователя с ботом
 * Например, это может быть:
 * <ul>
 *   <li>Текстовая информация, которую прислал пользователь по просьбе бота </li>
 *   <li>Данные, пришедшие после нажатия на кнопку Inline клавиатуры</li>
 * </ul>
 */

public interface Callback extends Serializable {
}