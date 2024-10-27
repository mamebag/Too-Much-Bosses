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

import java.util.EnumSet;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.Goal.Flag;

public class MoveAttackGoal<T extends Mob> extends Goal {
    private final T mob;
    private final double speedModifier;
    private final float attackRadiusSqr;
    private int seeTime;
    private boolean strafingClockwise;
    private boolean strafingBackwards;
    private int strafingTime = -1;

   /*public <M extends Monster & RangedAttackMob> RangedBowAttackGoal(M p_25792_, double p_25793_, int p_25794_, float p_25795_){
      this((T) p_25792_, p_25793_, p_25794_, p_25795_);
   }*/

   public MoveAttackGoal(T p_25792_, double p_25793_, float p_25795_) {
      this.mob = p_25792_;
      this.speedModifier = p_25793_;
      this.attackRadiusSqr = p_25795_ * p_25795_;
      this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
   }

   public boolean canUse() {
      return this.mob.getTarget() != null;
   }

   public boolean canContinueToUse() {
      return (this.canUse() || !this.mob.getNavigation().isDone());
   }

   public void start() {
      super.start();
      this.mob.setAggressive(true);
   }

   public void stop() {
      super.stop();
      this.mob.setAggressive(false);
      this.seeTime = 0;
   }

   public boolean requiresUpdateEveryTick() {
      return true;
   }

   public void tick() {
      LivingEntity livingentity = this.mob.getTarget();
      if (livingentity != null) {
         double d0 = this.mob.distanceToSqr(livingentity.getX(), livingentity.getY(), livingentity.getZ());
         boolean flag = this.mob.getSensing().hasLineOfSight(livingentity);
         boolean flag1 = this.seeTime > 0;
         if (flag != flag1) {
            this.seeTime = 0;
         }

         if (flag) {
            ++this.seeTime;
         } else {
            --this.seeTime;
         }

         if (!(d0 > (double)this.attackRadiusSqr) && this.seeTime >= 1) {
            this.mob.getNavigation().stop();
            ++this.strafingTime;
         } else {
            this.mob.getNavigation().moveTo(livingentity, this.speedModifier);
            this.strafingTime = -1;
         }

         if (this.strafingTime >= 20) {
            if ((double)this.mob.getRandom().nextFloat() < 0.3D) {
               this.strafingClockwise = !this.strafingClockwise;
            }

            if ((double)this.mob.getRandom().nextFloat() < 0.3D) {
               this.strafingBackwards = !this.strafingBackwards;
            }

            this.strafingTime = 0;
         }

         if (this.strafingTime > -1) {
            if (d0 > (double)(this.attackRadiusSqr * 0.75F)) {
               this.strafingBackwards = false;
            } else if (d0 < (double)(this.attackRadiusSqr * 0.25F)) {
               this.strafingBackwards = true;
            }

            this.mob.getMoveControl().strafe(this.strafingBackwards ? -0.5F : 0.5F, this.strafingClockwise ? 0.5F : -0.5F);
            this.mob.lookAt(livingentity, 180.0F, 180.0F);
         } else {
            this.mob.getLookControl().setLookAt(livingentity, 180.0F, 180.0F);
         }
      }
   }
}