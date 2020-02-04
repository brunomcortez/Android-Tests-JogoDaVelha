package com.brunocortez.jogodavelha.models

import org.junit.Assert
import org.junit.Before
import org.junit.Test

class GameTest {
    private lateinit var game: Game
    private lateinit var player: Player
    private lateinit var anotherPlayer: Player

    @Before
    @Throws(Exception::class)
    fun setUp() {
        game = Game("Heider", "William")
        player = game.player1
        anotherPlayer = game.player2
    }

    @Test
    @Throws(Exception::class)
    fun returnTrueIfHasThreeSameDiagonalCellsFromLeft() {
        val cell = Cell(player)
        game.cells[0][0] = cell
        game.cells[1][1] = cell
        game.cells[2][2] = cell
        val hasThreeSameDiagonalCells = game.hasThreeSameDiagonalCells()
        Assert.assertTrue(hasThreeSameDiagonalCells)
    }

}