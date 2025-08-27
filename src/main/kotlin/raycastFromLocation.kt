package io.github.loadeddock

import io.github.dockyardmc.location.Location
import io.github.dockyardmc.location.blockRaycast
import io.github.dockyardmc.maths.vectors.Vector3d
import io.github.dockyardmc.world.block.Block

fun raycastFromLocation(origin: Location, direction: Vector3d, maxDistance: Double, stepSize: Double = 0.1, passBlocks: Boolean): Pair<Location, Block> {

    if (!passBlocks) {

        val ray = blockRaycast(origin, direction, maxDistance, stepSize)

        if (ray != null) {
            return ray
        } else {
            val location = origin.add(direction.normalized() * Vector3d(maxDistance))
            val block = Block.AIR
            return Pair(location, block)
        }

    }
    else {
        val location = origin.add(direction.normalized() * Vector3d(maxDistance))
        val block = Block.AIR
        return Pair(location, block)
    }

}