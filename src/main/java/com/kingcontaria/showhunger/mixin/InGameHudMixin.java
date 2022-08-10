package com.kingcontaria.showhunger.mixin;

import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(InGameHud.class)

public class InGameHudMixin {

    @ModifyVariable(method = "renderStatusBars", at = @At("STORE"), ordinal = 0)
    private Entity showMyHunger(Entity entity) {
        if (!(entity instanceof LivingEntity)) {
            return null;
        }
        return entity;
    }

}
