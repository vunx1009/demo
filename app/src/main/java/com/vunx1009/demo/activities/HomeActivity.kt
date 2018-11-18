package com.vunx1009.demo.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.RecyclerView
import com.vunx1009.demo.R
import com.vunx1009.demo.adapters.KeywordAdapter
import com.vunx1009.demo.interfaces.IKeywordPresenter
import com.vunx1009.demo.interfaces.IkeywordView
import com.vunx1009.demo.objects.Keyword
import com.vunx1009.demo.presenters.KeywordPresenter

class HomeActivity : AppCompatActivity(), IkeywordView {

    private val presenter: IKeywordPresenter;
    private val adapter: KeywordAdapter;
    private lateinit var recyclerView: RecyclerView;


    init {
        presenter = KeywordPresenter(this)
        adapter = KeywordAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        presenter.setView(this)

        recyclerView = findViewById(R.id.rc_keywords)
        recyclerView.adapter = this.adapter

    }

    override fun onResume() {
        super.onResume()
        presenter.getKeywords()
    }

    override fun onDestroy() {
        presenter.onDestroy()
        super.onDestroy()
    }

    override fun updateSearchKeys(keywords: List<Keyword>) {
        adapter.setData(keywords)
    }
}
