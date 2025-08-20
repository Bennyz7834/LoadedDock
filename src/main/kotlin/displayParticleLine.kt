package io.github.loadeddock

import io.github.dockyardmc.player.Player
import io.github.dockyardmc.location.Location
import io.github.dockyardmc.particles.spawnParticle
import io.github.dockyardmc.registry.registries.Particle

fun Player.displayParticleLine(particle: Particle, startLocation: Location, endLocation: Location, effectSpacing: Float) {

    val maxDistance = startLocation.distance(endLocation)
    var currentDistance = 0.0f

    while (currentDistance <= maxDistance) {

        val displayLocation = startLocation.add(0.0f, 0.0f, effectSpacing)
        spawnParticle(particle = particle, location = displayLocation)

        currentDistance += effectSpacing
    }

}