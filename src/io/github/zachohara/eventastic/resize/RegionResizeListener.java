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

package io.github.zachohara.eventastic.resize;

import io.github.zachohara.eventastic.EventListener;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

public class RegionResizeListener extends EventListener<ResizeListenable, ResizeHandler> implements ChangeListener<Number> {
	
	public RegionResizeListener(SelfResizeHandler handler) {
		this(handler, handler);
	}
	
	public RegionResizeListener(ResizeListenable listenable, ResizeHandler handler) {
		super(handler);
		listenable.widthProperty().addListener(this);
		listenable.heightProperty().addListener(this);
	}

	@Override
	public void changed(ObservableValue<? extends Number> observable, Number oldValue,
			Number newValue) {
		this.getHandler().handleResize();
	}

}
