package com.brunocortez.jogodavelha.views.game

import androidx.databinding.ObservableArrayMap
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.brunocortez.jogodavelha.models.Cell
import com.brunocortez.jogodavelha.models.Game
import com.brunocortez.jogodavelha.models.Player
import com.brunocortez.jogodavelha.utils.StringUtility.stringFromNumbers

class GameViewModel: ViewModel() {

    lateinit var cells: ObservableArrayMap<String, String>
    private lateinit var game: Game
    val winner: LiveData<Player>
        get() = game.winner

    fun init(player1: String, player2: String) {
        game = Game(player1, player2)
        cells = ObservableArrayMap()
    }
    fun onClickedCellAt(row: Int, column: Int) {
        if (game.cells[row][column] == null) {
            game.cells[row][column] = Cell(game.currentPlayer)
            cells[stringFromNumbers(row, column)] = game.currentPlayer.value
            if (game.hasGameEnded())
                game.reset()
            else
                game.switchPlayer()
        }
    }
}