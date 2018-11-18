package com.vunx1009.demo.presenters

import android.content.Context
import com.vunx1009.demo.interfaces.ISearchKeyListener
import com.vunx1009.demo.interfaces.ISearchModel
import com.vunx1009.demo.interfaces.IKeywordPresenter
import com.vunx1009.demo.interfaces.ISearchView
import com.vunx1009.demo.models.SearchModel

class KeywordPresenter (val context: Context): IKeywordPresenter {

    private var model: ISearchModel
    private var view: ISearchView? = null

    init {
        model = SearchModel(context)
    }

    override fun setModel(model: ISearchModel) {
        this.model = model;
    }

    override fun setView(view: ISearchView) {
        this.view = view;
    }

    override fun getKeywords() {
        model.getKeywords(ISearchKeyListener { keywords -> view?.updateSearchKeys(keywords) })
    }

    override fun onDestroy() {
       view = null;
    }
}