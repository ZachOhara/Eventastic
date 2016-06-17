/* Copyright (C) 2016 Zach Ohara
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package io.github.zachohara.eventastic.button;

import io.github.zachohara.eventastic.EventListener;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;


public class ButtonPressListener extends EventListener<Button, ButtonHandler> implements EventHandler<ActionEvent> {
	
	public ButtonPressListener(Button listenable) {
		super();
		listenable.setOnAction(this);
	}

	@Override
	public void handle(ActionEvent event) {
		for (ButtonHandler handler : this.getHandlerList()) {
			handler.handleButtonPress();
		}
	}
	
	public static <H extends Button & ButtonHandler> ButtonPressListener createSelfListener(H handler) {
		ButtonPressListener listener = new ButtonPressListener(handler);
		listener.addHandler(handler);
		return listener;
	}

}
