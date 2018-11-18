package com.vunx1009.demo.interfaces

interface IKeywordPresenter {
    fun setModel(model: ISearchModel)
    fun setView(view: ISearchView)
    fun getKeywords()
    fun onDestroy()
}