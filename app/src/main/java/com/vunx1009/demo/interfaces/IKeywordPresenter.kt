package com.vunx1009.demo.interfaces

interface IKeywordPresenter {
    fun setModel(model: IKeywordModel)
    fun setView(view: IkeywordView)
    fun getKeywords()
    fun onDestroy()
}