package nowebsite.maker.gravityplan.eventhandler;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

public class RefreshAct {
    public static void requestBlockUpdates(@NotNull Level level, Vec3 pos) {
        if (!level.isClientSide) { // 确保只在服务器端运行
            int radius = 16; // 刷新区域的半径
            // 计算刷新区域的边界
            BlockPos minPos = BlockPos.containing(pos.add(-radius, -radius, -radius));
            BlockPos maxPos = BlockPos.containing(pos.add(radius, radius, radius));
            // 遍历每一个方块
            for (BlockPos blockPos : BlockPos.betweenClosed(minPos, maxPos)) {
                // 获取方块状态
                BlockState state = level.getBlockState(blockPos);
                // 向所有在这个区域内的玩家发送方块更新
                level.sendBlockUpdated(blockPos, state, state, 3);
            }
        }
    }

}
