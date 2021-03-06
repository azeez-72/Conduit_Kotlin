package io.realworld.conduit.ui.feed

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import io.realworld.conduit.databinding.FragmentFeedBinding

//use view binding
class GlobalFeedFragment : Fragment() {

    private var _binding : FragmentFeedBinding? = null
    private lateinit var viewModel : FeedViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFeedBinding.inflate(inflater,container,false)
        viewModel = ViewModelProvider(this).get(FeedViewModel::class.java)

        viewModel.fetchGlobalFeed()

        //root means a view(that is there inside a fragment)
        return _binding?.root    //creates a binding as soon as view is created
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null   //dump binding when destroyed
    }
}