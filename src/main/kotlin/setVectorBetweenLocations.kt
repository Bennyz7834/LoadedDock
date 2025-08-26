package io.github.loadeddock

import io.github.dockyardmc.location.Location
import io.github.dockyardmc.maths.vectors.Vector3d

fun setVectorBetweenLocations(startLocation: Location, endLocation: Location): Vector3d {

    return Vector3d(endLocation.x - startLocation.x, endLocation.y - startLocation.y, endLocation.z - startLocation.z)

}