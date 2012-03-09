package com.mojang.ld22.item;

import java.util.StringTokenizer;

import com.mojang.ld22.Dumpable;
import com.mojang.ld22.entity.Entity;
import com.mojang.ld22.entity.ItemEntity;
import com.mojang.ld22.entity.Player;
import com.mojang.ld22.entity.Workbench;
import com.mojang.ld22.gfx.Screen;
import com.mojang.ld22.level.Level;
import com.mojang.ld22.level.tile.Tile;
import com.mojang.ld22.screen.ListItem;

public class Item extends Dumpable implements ListItem {
	public static Object items;

	public int getColor() {
		return 0;
	}

	public int getSprite() {
		return 0;
	}

	public void onTake(ItemEntity itemEntity) {
	}

	@Override
	public void renderInventory(Screen screen, int x, int y) {
	}

	public boolean interact(Player player, Entity entity, int attackDir) {
		return false;
	}

	public void renderIcon(Screen screen, int x, int y) {
	}

	public boolean interactOn(Tile tile, Level level, int xt, int yt,
			Player player, int attackDir) {
		return false;
	}

	public boolean isDepleted() {
		return false;
	}

	public boolean canAttack() {
		return false;
	}

	public int getAttackDamageBonus(Entity e) {
		return 0;
	}

	public String getName() {
		return "";
	}

	public boolean matches(Item item) {
		return item.getClass() == getClass();
	}

	public boolean isResource() {
		return false;
	}

	@Override
	public void loadFrom(StringTokenizer st) {
		super.loadFrom(st);
	}

	@Override
	public void saveTo(StringBuffer str) {
		super.saveTo(str);
		str.append(getClass().getSimpleName() + " ");
	}

	static public Item get(StringTokenizer st) {
		String cl = st.nextToken();
		Item it = null;
		if (cl.equals("FurnitureItem")) {
			it = new FurnitureItem(new Workbench()); // !!!
		} else if (cl.equals("PowerGloveItem")) {
			it = new PowerGloveItem();
		} else if (cl.equals("ResourceItem")) {
			it = new ResourceItem(null); // !!!
		} else if (cl.equals("ToolItem")) {
			it = new ToolItem(null, 0);
		} else if (cl.equals("Item")) {
			it = new Item();
		} else {
			System.out.println("[Item] Unknow item: " + cl);
		}
		if (it != null) {
			it.loadFrom(st);
		}
		return it;
	}

}
