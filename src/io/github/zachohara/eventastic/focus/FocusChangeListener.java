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

package io.github.zachohara.eventastic.focus;

import io.github.zachohara.eventastic.EventListener;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

public final class FocusChangeListener extends EventListener<FocusListenable, FocusHandler> implements ChangeListener<Boolean> {
	
	public FocusChangeListener(SelfFocusHandler handler) {
		this(handler, handler);
	}
	
	public FocusChangeListener(FocusListenable listenable, FocusHandler handler) {
		super(handler);
		listenable.focusedProperty().addListener(this);
	}

	@Override
	public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
		this.getHandler().handleFocusChange(newValue);
	}

}
