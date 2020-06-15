package com.tamimapps.test


class Items {
    var id: String? = null
    var slug: String? = null
    var thumb: String? = null
    var profit: String? = null

    constructor() {}

    constructor(
        id: String?,
        name: String?,
        buy_price: String?,
        profit: String?
    ) {
        this.id = id
        this.slug = name
        this.thumb = buy_price
        this.profit = profit
    }

}