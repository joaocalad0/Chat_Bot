package com.example.chat_bot;

import android.content.Context;
import android.icu.text.SimpleDateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Date;
import java.util.List;
import java.util.Locale;

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.MessageViewHolder> {
    private List<Message> messageList;
    private Context context;

    public MessageAdapter(List<Message> messageList, Context context) {
        this.messageList = messageList;
        this.context = context;
    }

    @NonNull
    @Override
    public MessageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        if (viewType == 1) {
            view = LayoutInflater.from(context).inflate(R.layout.user_message_iteml, parent, false);
        } else {
            view = LayoutInflater.from(context).inflate(R.layout.bot_message_item, parent, false);
        }
        return new MessageViewHolder(view);
    }


    @Override
    public int getItemViewType(int position) {
        Message message = messageList.get(position);
        if (message.getSender().equals("Bot")) {
            return 0;
        } else {
            return 1;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull MessageViewHolder holder, int position) {
        Message message = messageList.get(position);
        holder.bind(message);
    }

    @Override
    public int getItemCount() {
        return messageList.size();
    }

    public class MessageViewHolder extends RecyclerView.ViewHolder {
        private TextView textViewSender;
        private TextView textViewContent;
        private TextView textViewTimestamp;

        public MessageViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewSender = itemView.findViewById(R.id.text_view_sender_bot);
            textViewContent = itemView.findViewById(R.id.text_view_content_bot);
            textViewTimestamp = itemView.findViewById(R.id.text_view_timestamp_bot);


            //ids user
            textViewSender = itemView.findViewById(R.id.text_view_sender_user);
            textViewContent = itemView.findViewById(R.id.text_view_content_user);
            textViewTimestamp = itemView.findViewById(R.id.text_view_timestamp_user);
        }



        public void bind(Message message) {
            textViewSender.setText(message.getSender());
            textViewContent.setText(message.getContent());

            long timestamp = message.getTimestamp();
            String formattedTimestamp = formatDate(timestamp);
            textViewTimestamp.setText(formattedTimestamp);
        }

        private String formatDate(long timestamp) {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.getDefault());
            return sdf.format(new Date(timestamp));
        }
    }

    public void refreshList(List<Message> newMessageList) {
        messageList.clear();
        messageList.addAll(newMessageList);
        notifyDataSetChanged();
    }
}
