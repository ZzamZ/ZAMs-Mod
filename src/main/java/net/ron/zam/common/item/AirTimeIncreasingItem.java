package net.ron.zam.common.item;

import net.minecraft.ChatFormatting;
import net.minecraft.advancements.triggers.CriteriaTriggers;
import net.minecraft.network.chat.CommonComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stats;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.alchemy.PotionContents;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.level.Level;

import java.util.List;
import java.util.function.Consumer;

public class AirTimeIncreasingItem extends Item {
    private final List<MobEffectInstance> effects;
    private final int airTickIncrease;
    private static final int FULL_REFILL = -1;

    protected AirTimeIncreasingItem(Properties properties) {
        this(FULL_REFILL, properties);
    }

    public AirTimeIncreasingItem(int airTickIncrease, Properties settings) {
        this(List.of(), airTickIncrease, settings);
    }

    public AirTimeIncreasingItem(List<MobEffectInstance> effects, int airTickIncrease, Properties settings) {
        super(settings);
        this.effects = effects;
        this.airTickIncrease = airTickIncrease;
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level world, LivingEntity user) {
        if (user instanceof ServerPlayer serverPlayer) {
            CriteriaTriggers.CONSUME_ITEM.trigger(serverPlayer, stack);
            serverPlayer.awardStat(Stats.ITEM_USED.get(this));
        }

        int maxAir = user.getMaxAirSupply();
        user.setAirSupply(airTickIncrease == FULL_REFILL
                ? maxAir
                : Math.min(maxAir, user.getAirSupply() + airTickIncrease));

        return super.finishUsingItem(stack, world, user);
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, TooltipDisplay display, Consumer<Component> tooltip, TooltipFlag type) {
        super.appendHoverText(stack, context, display, tooltip, type);

        if (effects != null && !effects.isEmpty()) {
            PotionContents.addPotionTooltip(effects, tooltip, 1.0F, context.tickRate());
        }

        tooltip.accept(CommonComponents.EMPTY);
        tooltip.accept(Component.translatable("tooltip.zam.when_eaten").withStyle(ChatFormatting.GRAY));
        tooltip.accept(Component.translatable("tooltip.zam.air_time").withStyle(ChatFormatting.BLUE));
    }
}