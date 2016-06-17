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

package io.github.zachohara.eventastic.window;

import io.github.zachohara.eventastic.EventListener;
import javafx.event.EventHandler;
import javafx.stage.WindowEvent;

public class WindowEventListener extends EventListener<WindowListenable, WindowHandler> implements EventHandler<WindowEvent> {
	
	public WindowEventListener(SelfWindowHandler handler) {
		this(handler, handler);
	}
	
	public WindowEventListener(WindowListenable listenable, WindowHandler handler) {
		super(handler);
		listenable.setOnCloseRequest(this);
		listenable.setOnHidden(this);
		listenable.setOnHiding(this);
		listenable.setOnShown(this);
		listenable.setOnShowing(this);
	}

	@Override
	public void handle(WindowEvent event) {
		this.getHandler().handleWindowEvent(event, event.getEventType());
	}
	
}
