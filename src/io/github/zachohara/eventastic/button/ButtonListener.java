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


public class ButtonListener extends EventListener<Button, ButtonHandler> implements EventHandler<ActionEvent> {
	
	public <H extends Button & ButtonHandler> ButtonListener(H handler) {
		this(handler, handler);
	}
	
	public ButtonListener(Button listenable, ButtonHandler handler) {
		super(handler);
		listenable.setOnAction(this);
	}

	@Override
	public void handle(ActionEvent event) {
		this.getHandler().handleButtonPress();
	}

}
