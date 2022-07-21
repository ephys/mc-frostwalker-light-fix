package be.ephys.frostwalkerlightfix.mixins;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.block.FrostedIceBlock;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(FrostedIceBlock.class)
public class FrostedIceBlockMixin {

  @Redirect(
    method = "tick",
    at = @At(value = "INVOKE", target = "Lnet/minecraft/server/level/ServerLevel;getMaxLocalRawBrightness(Lnet/minecraft/core/BlockPos;)I")
  )
  public int tick$hackLightLevel(ServerLevel instance, BlockPos blockPos) {
    return 15;
  }
}
