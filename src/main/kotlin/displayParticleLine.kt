package io.github.loadeddock

import io.github.dockyardmc.player.Player
import io.github.dockyardmc.world.World
import io.github.dockyardmc.location.Location
import io.github.dockyardmc.maths.vectors.Vector3d
import io.github.dockyardmc.particles.spawnParticle
import io.github.dockyardmc.registry.registries.Particle

fun Player.displayParticleLine(particle: Particle, startLocation: Location, endLocation: Location, effectSpacing: Double = 0.1) {

    val vectorBetween = setVectorBetweenLocations(startLocation, endLocation)
    var currentLocation = startLocation.setDirection(vectorBetween)

    val maxDistance = startLocation.distance(endLocation)
    var currentDistance = 0.0

    val stepVec = currentLocation.getDirection(false).normalized() * Vector3d(effectSpacing)

    while (currentDistance <= maxDistance) {

        currentLocation = currentLocation.add(stepVec)
        spawnParticle(particle = particle, location = currentLocation)

        currentDistance += effectSpacing

    }

}


fun World.displayParticleLine(particle: Particle, startLocation: Location, endLocation: Location, effectSpacing: Double) {

    this.players.displayParticleLine(particle, startLocation, endLocation, effectSpacing)

}


fun Collection<Player>.displayParticleLine(particle: Particle, startLocation: Location, endLocation: Location, effectSpacing: Double) {

    this.forEach {player -> player.displayParticleLine(particle, startLocation, endLocation, effectSpacing)}

}