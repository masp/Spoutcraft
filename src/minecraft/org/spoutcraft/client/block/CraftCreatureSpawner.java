/*
 * This file is part of Bukkit (http://bukkit.org/).
 *
 * Bukkit is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Bukkit is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
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
package org.spoutcraft.client.block;

import net.minecraft.src.TileEntityMobSpawner;

import org.spoutcraft.client.SpoutcraftWorld;
import org.spoutcraft.spoutcraftapi.block.Block;
import org.spoutcraft.spoutcraftapi.block.CreatureSpawner;
import org.spoutcraft.spoutcraftapi.entity.CreatureType;

public class CraftCreatureSpawner extends CraftBlockState implements CreatureSpawner {
	private final SpoutcraftWorld world;
	private final TileEntityMobSpawner spawner;

	public CraftCreatureSpawner(final Block block) {
		super(block);

		world = (SpoutcraftWorld) block.getWorld();
		spawner = (TileEntityMobSpawner) world.getHandle().getBlockTileEntity(getX(), getY(), getZ());
	}

	public CreatureType getCreatureType() {
		return CreatureType.fromName(spawner.getMobID());
	}

	public void setCreatureType(CreatureType creatureType) {
		spawner.setMobID(creatureType.getName());
	}

	public String getCreatureTypeId() {
		return spawner.getMobID();
	}

	public void setCreatureTypeId(String creatureType) {
		// Verify input
		CreatureType type = CreatureType.fromName(creatureType);
		if (type == null) {
			return;
		}
		spawner.setMobID(type.getName());
	}

	public int getDelay() {
		return spawner.delay;
	}

	public void setDelay(int delay) {
		spawner.delay = delay;
	}
}
