package com.disha.rickymorty.presentation.di.characters


import com.disha.rickymorty.presentation.characters.CharacterActivity
import dagger.Subcomponent

@CharacterScope
@Subcomponent(modules = [CharacterModule::class])
interface CharacterSubComponent {
    fun inject(characterActivity:CharacterActivity)

    @Subcomponent.Factory
    interface Factory{
        fun create():CharacterSubComponent
    }

}

