package com.vunx1009.demo.presenters

import android.content.Context
import com.vunx1009.demo.interfaces.ISearchKeyListener
import com.vunx1009.demo.interfaces.IKeywordModel
import com.vunx1009.demo.interfaces.IKeywordPresenter
import com.vunx1009.demo.interfaces.IkeywordView
import com.vunx1009.demo.models.KeywordModel

class KeywordPresenter (val context: Context): IKeywordPresenter {

    private var model: IKeywordModel
    private var view: IkeywordView? = null

    init {
        model = KeywordModel(context)
    }

    override fun setModel(model: IKeywordModel) {
        this.model = model;
    }

    override fun setView(view: IkeywordView) {
        this.view = view;
    }

    override fun getKeywords() {
        model.getKeywords(ISearchKeyListener { keywords -> view?.updateSearchKeys(keywords) })
    }

    override fun onDestroy() {
       view = null;
    }
}