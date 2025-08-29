package io.github.loadeddock

import io.github.dockyardmc.location.Location
import io.github.dockyardmc.location.blockRaycast
import io.github.dockyardmc.maths.vectors.Vector3d
import io.github.dockyardmc.world.block.Block

fun raycastFromLocation(origin: Location, direction: Vector3d, maxDistance: Double, stepSize: Double = 0.1, passableBlocks: Array<Block> = emptyArray()): Pair<Location, Block> {

    var travelledDistance = 0.0
    var currentLocation = origin
    var distanceRemain = maxDistance
    val stepVec = direction.normalized() * Vector3d(stepSize)

    if (passableBlocks.isNotEmpty()) {

        while (travelledDistance < maxDistance) {

            if (passableBlocks.contains(currentLocation.block)) {

                currentLocation = currentLocation.add(stepVec)
                travelledDistance += stepSize
                distanceRemain -= stepSize
                continue

            }

            var ray = blockRaycast(currentLocation, direction, distanceRemain, stepSize)

            if (ray != null) {

                currentLocation = ray.first
                travelledDistance += currentLocation.distance(origin)
                distanceRemain -= currentLocation.distance(origin)

            } else {

                val location = origin.add(direction.normalized() * Vector3d(maxDistance))
                return Pair(location, Block.AIR)
            }

        }
        return Pair(currentLocation, currentLocation.block)

    }

    val ray = blockRaycast(origin, direction, maxDistance, stepSize)

    if (ray != null) {
        return ray

    } else {

        val location = origin.add(direction.normalized() * Vector3d(maxDistance))
        return Pair(location, location.block)
    }

}