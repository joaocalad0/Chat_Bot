package com.example.chat_bot;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.ChatViewHolder> {

    // variável de instância que armazena a lista de Contactos que este Adapter vai utilizar
    private List<Chat> chatList;

    private ChatAdapterEventListener eventListener;

    /**
     * Construtor que um objeto que implemente o interface ContactAdapterEventListener
     * @param eventLister
     */
    public ChatAdapter(ChatAdapterEventListener eventLister) {
        // armazenar na variável de instância o valor do parâmetro do construtor
        this.chatList = new ArrayList<>();
        this.eventListener = eventLister;
    }

    /**
     * Criar um novo ViewHolder sempre que for necessário
     * @param parent The ViewGroup into which the new View will be added after it is bound to
     *               an adapter position.
     * @param viewType The view type of the new View.
     *
     * @return
     */
    @NonNull
    @Override
    public ChatViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Criar um objeto do tipo View com base no layout criado (contact_item.xml)
        if (viewType == 1) {
            // is Favorite
            View rootView = LayoutInflater.from(parent.getContext()).inflate(R.layout.chat_item_favorite, parent, false);
            // criar e devolver um objeto do tipo ContactViewHolder
            return new ChatFavoriteViewHolder(rootView);
        }
        View rootView = LayoutInflater.from(parent.getContext()).inflate(R.layout.chat_item, parent, false);
        // criar e devolver um objeto do tipo ContactViewHolder
        return new ChatNormalViewHolder(rootView);
    }

    /**
     * Permite associar a um ViewHolder dados de um item da lista
     * @param holder The ViewHolder which should be updated to represent the contents of the
     *        item at the given position in the data set.
     * @param position The position of the item within the adapter's data set.
     */
    @Override
    public void onBindViewHolder(@NonNull ChatViewHolder holder, int position) {
        // obter o chat que existe na lista na posição dada pelo parâmetro position
        final Chat chat = this.chatList.get(position);
        // definir que o valor da TextView no ViewHolder passa a conter o valor da propriedade name do Chat
        holder.textViewName.setText(chat.getName());
        //Glide.with(holder.rootView.getContext()).load(chat.getAvatar()).into(holder.imageViewAvatar);

        holder.rootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (eventListener != null) eventListener.onChatClicked(chat.getId());
            }
        });

        holder.rootView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (eventListener != null) {
                    eventListener.onChatLongClicked(chat.getId());
                    return true;
                } else {
                    return false;
                }
            }
        });
    }

    /**
     * Devolver o número de Items que a RecyclerView deve apresentar
     * @return numero de items da recyclerView
     */
    @Override
    public int getItemCount() {
        return this.chatList.size();
    }

    @Override
    public int getItemViewType(int position) {
        Chat chat = chatList.get(position);
//        if (contact.isFavorite()) {
//            return 1;
//        }
//        return 0;
        return chat.isFavorite() ? 1 : 0;
    }

    public void refreshList(List<Chat> newChatList) {
        this.chatList = newChatList;
        notifyDataSetChanged();
    }

    public class ChatViewHolder extends RecyclerView.ViewHolder {

        private View rootView;
        private TextView textViewName;
        private ImageView imageViewAvatar;

        public ChatViewHolder(@NonNull View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.textViewName = rootView.findViewById(R.id.textViewName);
            this.imageViewAvatar = rootView.findViewById(R.id.imageViewAvatar);
        }
    }

    public class ChatFavoriteViewHolder extends ChatViewHolder {
        public ChatFavoriteViewHolder(@NonNull View rootView) {
            super(rootView);
        }
    }

    public class ChatNormalViewHolder extends ChatViewHolder {
        public ChatNormalViewHolder(@NonNull View rootView) {
            super(rootView);
        }
    }

    public interface ChatAdapterEventListener {
        void onChatClicked(long chatId);
        void onChatLongClicked(long chattId);
    }
}