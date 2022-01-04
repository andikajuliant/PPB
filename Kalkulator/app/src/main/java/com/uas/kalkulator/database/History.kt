package com.uas.kalkulator.database

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(tableName = "tb_history")
@Parcelize
data class History(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Int = 0,

    @ColumnInfo(name = "numberOne")
    val numberOne: String? = null,

    @ColumnInfo(name = "operator")
    val operator: String? = null,

    @ColumnInfo(name = "numberTwo")
    val numberTwo: String? = null,

    @ColumnInfo(name = "result")
    val result: String? = null
) : Parcelable