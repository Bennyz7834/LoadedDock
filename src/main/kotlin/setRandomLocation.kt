package io.github.loadeddock

import io.github.dockyardmc.location.Location
import kotlin.random.Random

fun setRandomLocation(location1: Location, location2: Location): Location {

    if (location1.world != location2.world) {
        error("location1 & location2 world does not match.")
    }

    return Location(Random.nextDouble(location1.x, location2.x), Random.nextDouble(location1.y, location2.y), Random.nextDouble(location1.z, location2.z), location1.world)

}

