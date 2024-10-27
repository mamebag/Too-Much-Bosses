/**
 * The code of this mod element is always locked.
 *
 * You can register new events in this class too.
 *
 * If you want to make a plain independent class, create it using
 * Project Browser -> New... and make sure to make the class
 * outside net.mcreator.toomuchbosses as this package is managed by MCreator.
 *
 * If you change workspace package, modid or prefix, you will need
 * to manually adapt this file to these changes or remake it.
 *
 * This class will be added in the mod root package.
*/
package net.mcreator.toomuchbosses;

import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.Mob;

import java.util.EnumSet;

public class MakeHostileGoal<T extends IMinion> extends Goal {
	private final Mob mob;
	private final IMinion OwnerChecker;

	public MakeHostileGoal(T mobIn) {
		this.mob = (Mob) mobIn;
		this.OwnerChecker = mobIn;
		this.setFlags(EnumSet.of(Goal.Flag.TARGET));
	}

	public boolean canUse() {
		if (this.OwnerChecker.getOwner() != null && this.OwnerChecker.getOwner().isAlive() && mob.getTarget() == null) {
			return this.OwnerChecker.getOwner().getTarget() != null;
		}
		return false;
	}

	public boolean canContinueToUse() {
		return !(this.OwnerChecker.getOwner() != null && this.OwnerChecker.getOwner().isAlive())
				&& this.mob.getTarget() != this.OwnerChecker.getOwner();
	}

	public void tick() {
		this.mob.setTarget(this.OwnerChecker.getOwner().getTarget());
	}
}

