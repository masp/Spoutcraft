/*
 * This file is part of Spoutcraft (http://www.spout.org/).
 *
 * Spoutcraft is licensed under the SpoutDev License Version 1.
 *
 * Spoutcraft is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * In addition, 180 days after any changes are published, you can use the
 * software, incorporating those changes, under the terms of the MIT license,
 * as described in the SpoutDev License Version 1.
 *
 * Spoutcraft is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License,
 * the MIT license and the SpoutDev license version 1 along with this program.
 * If not, see <http://www.gnu.org/licenses/> for the GNU Lesser General Public
 * License and see <http://www.spout.org/SpoutDevLicenseV1.txt> for the full license,
 * including the MIT license.
 */
package org.spoutcraft.client.gui.texturepacks;

import java.util.HashMap;

import org.spoutcraft.client.gui.database.AbstractAPIModel;

public class TexturePacksDatabaseModel extends AbstractAPIModel {
	public TexturePacksDatabaseModel() {
		API = "http://textures.spout.org/api2.php";
	}

	@Override
	protected void refreshList(boolean clear) {
		if (clear) {
			entries.clear();
		}
		for (Object obj:apiData) {
			HashMap<String, Object> item = (HashMap<String, Object>) obj;
			TextureItem t = new TextureItem();
			t.setName((String) item.get("name"));
			t.setAuthor((String) item.get("authors"));
			t.setResolution(Integer.valueOf((String) item.get("resolution")));
			t.setId(Integer.valueOf((String) item.get("Id")));
			t.setDescription((String) item.get("desc"));
			t.setSize((Integer) item.get("size"));
			t.setForumlink((String) item.get("forumlink"));
			t.updateInstalled();
			entries.add(t);
		}
		update();
	}

	public String getDefaultUrl() {
		return "http://textures.spout.org/api2.php?featured";
	}
}
