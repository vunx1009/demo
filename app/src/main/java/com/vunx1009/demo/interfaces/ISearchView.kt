package com.vunx1009.demo.interfaces

import com.vunx1009.demo.objects.Keyword

interface ISearchView {
    fun updateSearchKeys(keywords : List<Keyword>)
}