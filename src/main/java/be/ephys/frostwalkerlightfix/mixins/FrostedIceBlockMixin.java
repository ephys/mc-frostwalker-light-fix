package be.ephys.frostwalkerlightfix.mixins;

import net.minecraft.block.FrostedIceBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.server.ServerWorld;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(FrostedIceBlock.class)
public class FrostedIceBlockMixin {

  @Redirect(
    method = "tick",
    at = @At(value = "INVOKE", target = "Lnet/minecraft/world/server/ServerWorld;getMaxLocalRawBrightness(Lnet/minecraft/util/math/BlockPos;)I")
  )
  public int tick$hackLightLevel(ServerWorld serverWorld, BlockPos pos) {
    return 15;
  }
}
