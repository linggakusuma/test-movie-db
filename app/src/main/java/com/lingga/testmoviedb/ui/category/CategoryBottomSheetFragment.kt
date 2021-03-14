package com.lingga.testmoviedb.ui.category

import android.content.Context
import android.os.Bundle
import android.view.View
import com.lingga.testmoviedb.R
import com.lingga.testmoviedb.databinding.FragmentCategoryBottomSheetBinding
import com.lingga.testmoviedb.ui.base.BaseBottomSheetFragment
import com.lingga.testmoviedb.utils.Constant

class CategoryBottomSheetFragment :
    BaseBottomSheetFragment<FragmentCategoryBottomSheetBinding>(R.layout.fragment_category_bottom_sheet) {

    private var mListener: CategoryItemClickListener? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        binding.apply {
            popular.setOnClickListener {
                dismissAllowingStateLoss()
                mListener?.onItemClick(Constant.POPULAR)
            }

            upcoming.setOnClickListener {
                dismissAllowingStateLoss()
                mListener?.onItemClick(Constant.UPCOMING)
            }

            topRated.setOnClickListener {
                dismissAllowingStateLoss()
                mListener?.onItemClick(Constant.TOP_RATED)
            }

            nowPlaying.setOnClickListener {
                dismissAllowingStateLoss()
                mListener?.onItemClick(Constant.NOW_PLAYING)
            }
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is CategoryItemClickListener) {
            mListener = context
        } else {
            throw RuntimeException(
                "$context must implement ItemClickListener"
            )
        }
    }

    override fun onDetach() {
        super.onDetach()
        mListener = null
    }
}