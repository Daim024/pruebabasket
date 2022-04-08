package com.iglesias.basket

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private var scoreTeamA = 0
    private var scoreTeamB = 0
    //views
    private lateinit var teamAScoreTextView: TextView
    private lateinit var teamBScoreTextView: TextView
    private lateinit var teamAAddButton: Button
    private lateinit var teamBAddButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(TAG, "onCreate")
        bind()
        setupScores(savedInstanceState)
        addListeners()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(KEY_SCORE_TEAM_A,scoreTeamA)
        outState.putInt(KEY_SCORE_TEAM_B,scoreTeamB)
        Log.d(TAG, "onSaveinstance")
    }

    private fun addListeners(){
        teamAAddButton.setOnClickListener{
            scoreTeamA++
            teamAScoreTextView.text = scoreTeamA.toString()
        }

        teamBAddButton.setOnClickListener{
            scoreTeamB++
            teamBScoreTextView.text = scoreTeamB.toString()
        }
    }

    private fun updateScore(view: TextView, score:Int) {
        view.text = score.toString()
    }

    private fun setupScores(savedInstanceState: Bundle?) {
        savedInstanceState?.let {savedInstanceState ->
            scoreTeamA = savedInstanceState.getInt(KEY_SCORE_TEAM_A,0)
            scoreTeamB = savedInstanceState.getInt(KEY_SCORE_TEAM_B,0)
        }
        teamAScoreTextView.text = scoreTeamA.toString()
        teamBScoreTextView.text = scoreTeamB.toString()
    }

    private fun bind() {
        //Team A
        teamAScoreTextView = findViewById(R.id.score_team_a_text_view)
        teamAAddButton = findViewById(R.id.action_add_team_a)
        //Team B
        teamBScoreTextView = findViewById(R.id.score_team_b_text_view)
        teamBAddButton = findViewById(R.id.action_add_team_b)
    }


    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onStart")
    }

    companion object {

        private val TAG = MainActivity::class.simpleName
        private const val KEY_SCORE_TEAM_A = "ScoreTeamA"
        private const val KEY_SCORE_TEAM_B = "ScoreTeamB"
    }
}