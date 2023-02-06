package com.clock.clocks.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.clock.clocks.data.models.*

@Dao
interface SettingsDao {
    @Insert
    fun insertClockColor(clockColorModel: ClockColorModel)
    @Query("SELECT * FROM clockColorModel WHERE id=:id")
    fun getClockColor(id: Int): ClockColorModel

    @Query("SELECT * FROM clockColorModel ORDER BY id DESC LIMIT 1")
    fun getLastProductClockLive(): ClockColorModel
    @Insert
    fun insertBackground(backgroundModel: BackgroundModel)
    @Query("SELECT * FROM backgroundModel WHERE id=:id")
    fun getBackgroundColor(id: Int): BackgroundModel

    @Query("SELECT * FROM backgroundModel ORDER BY id DESC LIMIT 1")
    fun getLastProductBackgroundLive(): BackgroundModel

    @Insert
    fun insertClockFont(clockFontModel: ClockFontModel)
    @Query("SELECT * FROM clockFontModel WHERE id=:id")
    fun getClockFontModel(id: Int): ClockFontModel

    @Query("SELECT * FROM clockFontModel ORDER BY id DESC LIMIT 1")
    fun getLastProductClockFontModelLive(): ClockFontModel

    @Insert
    fun insertClockOrientation(clockOrientation: ClockOrientation)
    @Query("SELECT * FROM clockOrientation WHERE id=:id")
    fun getClockOrientation(id: Int): ClockOrientation

    @Query("SELECT * FROM clockOrientation ORDER BY id DESC LIMIT 1")
    fun getLastProductCClockOrientationLive(): ClockOrientation


    @Insert
    fun insertWhenPortraitModeModel (whenPortraitModeModel: WhenPortraitModeModel)
    @Query("SELECT * FROM whenPortraitModeModel WHERE id=:id")
    fun getWhenPortraitModeModel (id: Int): WhenPortraitModeModel

    @Query("SELECT * FROM whenPortraitModeModel ORDER BY id DESC LIMIT 1")
    fun getLastProductWhenPortraitModeModelLive(): WhenPortraitModeModel


    @Insert
    fun insertUse24HourFormat (use24HourFormat: Use24HourFormat)
    @Query("SELECT * FROM use24HourFormat WHERE id=:id")
    fun getUse24HourFormat(id: Int): Use24HourFormat

    @Query("SELECT * FROM use24HourFormat ORDER BY id DESC LIMIT 1")
    fun getLastProductUse24HourFormatLive(): Use24HourFormat


    @Insert
    fun insertShowLeadingZeroForHoursModel (showLeadingZeroForHoursModel: ShowLeadingZeroForHoursModel)
    @Query("SELECT * FROM showLeadingZeroForHoursModel WHERE id=:id")
    fun getShowLeadingZeroForHoursModel(id: Int): ShowLeadingZeroForHoursModel

    @Query("SELECT * FROM showLeadingZeroForHoursModel ORDER BY id DESC LIMIT 1")
    fun getLastProductShowLeadingZeroForHoursModelLive(): ShowLeadingZeroForHoursModel

    @Insert
    fun insertSeperatorStyleModel (seperatorStyleModel: SeperatorStyleModel)
    @Query("SELECT * FROM seperatorStyleModel WHERE id=:id")
    fun getSeperatorStyleModel(id: Int): SeperatorStyleModel

    @Query("SELECT * FROM seperatorStyleModel ORDER BY id DESC LIMIT 1")
    fun getLastProductSeperatorStyleModelLive(): SeperatorStyleModel

    @Insert
    fun insertShowWeatherStyleInformationModel (showWeatherStyleInformationModel: ShowWeatherStyleInformationModel)
    @Query("SELECT * FROM showWeatherStyleInformationModel WHERE id=:id")
    fun getShowWeatherStyleInformationModel(id: Int): ShowWeatherStyleInformationModel

    @Query("SELECT * FROM showWeatherStyleInformationModel ORDER BY id DESC LIMIT 1")
    fun getLastProductShowWeatherStyleInformationModelLive(): ShowWeatherStyleInformationModel


    @Insert
    fun insertClockAppearanceModel (clockAppearanceModel: ClockAppearanceModel)
    @Query("SELECT * FROM clockAppearanceModel WHERE id=:id")
    fun getClockAppearanceModel(id: Int): ClockAppearanceModel

    @Query("SELECT * FROM clockAppearanceModel ORDER BY id DESC LIMIT 1")
    fun getLastProductClockAppearanceModelLive(): ClockAppearanceModel

    @Insert
    fun insertShowSecondsModel (showSecondsModel: ShowSecondsModel)
    @Query("SELECT * FROM showSecondsModel WHERE id=:id")
    fun getShowSecondsModel (id: Int): ShowSecondsModel

    @Query("SELECT * FROM showSecondsModel ORDER BY id DESC LIMIT 1")
    fun getLastProductShowSecondsModelLive(): ShowSecondsModel

    @Insert
    fun insertShowDateModel (showDateModel: ShowDateModel)
    @Query("SELECT * FROM showDateModel WHERE id=:id")
    fun getShowDateModel (id: Int): ShowDateModel

    @Query("SELECT * FROM showDateModel ORDER BY id DESC LIMIT 1")
    fun getLastProductShowDateModelLive(): ShowDateModel

    @Insert
    fun insertDateFormatModel (dateFormatModel: DateFormatModel)
    @Query("SELECT * FROM dateFormatModel WHERE id=:id")
    fun getDateFormatModel (id: Int): DateFormatModel

    @Query("SELECT * FROM dateFormatModel ORDER BY id DESC LIMIT 1")
    fun getLastProductDateFormatModelLive(): DateFormatModel

    @Insert
    fun insertShowDayModel (showDayModel: ShowDayModel)
    @Query("SELECT * FROM showDayModel WHERE id=:id")
    fun getShowDayModel (id: Int): ShowDayModel

    @Query("SELECT * FROM showDayModel ORDER BY id DESC LIMIT 1")
    fun getLastProductShowDayModelLive(): ShowDayModel

    @Insert
    fun insertShowDayNameModel (showDayNameModel: ShowDayNameModel)
    @Query("SELECT * FROM showDayNameModel WHERE id=:id")
    fun getShowDayNameModel (id: Int): ShowDayNameModel

    @Query("SELECT * FROM showDayNameModel ORDER BY id DESC LIMIT 1")
    fun getLastProductShowDayNameModelLive(): ShowDayNameModel

    @Insert
    fun insertHideStatusBarModel (hideStatusBarModel: HideStatusBarModel)
    @Query("SELECT * FROM hideStatusBarModel WHERE id=:id")
    fun getHideStatusBarModel (id: Int): HideStatusBarModel

    @Query("SELECT * FROM hideStatusBarModel ORDER BY id DESC LIMIT 1")
    fun getLastProductHideStatusBarModelLive(): HideStatusBarModel

    @Insert
    fun insertAutomaticallyHideModel (automaticallyHideModel: AutomaticallyHideModel)
    @Query("SELECT * FROM automaticallyHideModel WHERE id=:id")
    fun getAutomaticallyHideModel (id: Int): AutomaticallyHideModel

    @Query("SELECT * FROM automaticallyHideModel ORDER BY id DESC LIMIT 1")
    fun getLastProductAutomaticallyHideModelLive(): AutomaticallyHideModel

    @Insert
    fun insertSetLanguageModel (setLanguageModel: SetLanguageModel)
    @Query("SELECT * FROM setLanguageModel WHERE id=:id")
    fun getSetLanguageModel (id: Int): SetLanguageModel

    @Query("SELECT * FROM setLanguageModel ORDER BY id DESC LIMIT 1")
    fun getLastProductSetLanguageModelLive(): SetLanguageModel

    @Insert
    fun insertNightModeModel (nightModeModel: NightModeModel)
    @Query("SELECT * FROM nightModeModel WHERE id=:id")
    fun getNightModeModel (id: Int): NightModeModel

    @Query("SELECT * FROM nightModeModel ORDER BY id DESC LIMIT 1")
    fun getLastProductNightModeModelLive(): NightModeModel



}