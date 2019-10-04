package com.example.crashtest.webviewcrash.ui.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.example.crashtest.webviewcrash.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

public class MainFragment extends Fragment {

	private MainViewModel mViewModel;

	public static MainFragment newInstance() {
		return new MainFragment();
	}

	@Nullable
	@Override
	public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
													 @Nullable Bundle savedInstanceState) {
		final View view = inflater.inflate(R.layout.main_fragment, container, false);

		final WebView webView = view.findViewById(R.id.web_view);
		final String html = "<html><body><select><option>1</option><option>2</option></select></body></html>";
		webView.loadDataWithBaseURL(null, html, "text/html", "utf-8", null);

		return view;
	}

	@Override
	public void onActivityCreated(@Nullable Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		mViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
		// TODO: Use the ViewModel
	}

}
