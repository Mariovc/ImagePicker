/*
 * Copyright 2017 Mario Velasco Casquero
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.mvc.imagepicker.sample;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.mvc.imagepicker.ImagePicker;

import java.io.IOException;
import java.io.InputStream;

/**
 * Author: Mario Velasco Casquero
 * Date: 21/03/2017
 */

public class MainFragment extends Fragment {

    private ImageView imageView;
    private TextView textView;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // width and height will be at least 600px long (optional).
        ImagePicker.setMinQuality(600, 600);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_main, container, false);
        imageView = (ImageView) v.findViewById(R.id.image_view);
        textView = (TextView) v.findViewById(R.id.image_stream_indicator);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImagePicker.pickImage(MainFragment.this, "Select your image:");
            }
        });
        return v;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        Bitmap bitmap = ImagePicker.getImageFromResult(getActivity(), requestCode, resultCode, data);
        if (bitmap != null) {
            imageView.setImageBitmap(bitmap);
        }
        InputStream is = ImagePicker.getInputStreamFromResult(getActivity(), requestCode, resultCode, data);
        if (is != null) {
            textView.setText("Got input stream!");
            try {
                is.close();
            } catch (IOException ex) {
                // ignore
            }
        } else {
            textView.setText("Failed to get input stream!");
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
