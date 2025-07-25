package com.powerfinance.app.adapter;

import android.graphics.Color; // Importe Color
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.powerfinance.app.R; // Certifique-se de que esta importação está correta
import com.powerfinance.app.model.Expense; // Importe sua classe Expense

import java.util.ArrayList; // É uma boa prática usar ArrayList para listas mutáveis
import java.util.List;
import java.util.Locale;

public class ExpenseAdapter extends RecyclerView.Adapter<ExpenseAdapter.ExpenseViewHolder> {

    // Inicialize com uma lista vazia para evitar NullPointerException se não for fornecida inicialmente
    private List<Expense> expenseList = new ArrayList<>();

    // Construtor padrão (pode ser útil se você for adicionar itens depois)
    public ExpenseAdapter() {
        // Lista vazia por padrão
    }

    // Construtor que aceita uma lista inicial de despesas
    public ExpenseAdapter(List<Expense> initialExpenseList) {
        if (initialExpenseList != null) {
            this.expenseList = new ArrayList<>(initialExpenseList); // Cria uma cópia para evitar modificações externas
        }
    }

    @NonNull
    @Override
    public ExpenseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_expense, parent, false);
        return new ExpenseViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ExpenseViewHolder holder, int position) {
        Expense expense = expenseList.get(position);
        holder.tvItemDescription.setText(expense.getDescription());
        holder.tvItemAmount.setText(String.format(Locale.getDefault(), "R$ %.2f", expense.getAmount()));
        holder.tvItemDueDate.setText(expense.getDueDate());

        // Lógica para mudar a cor se a despesa estiver paga ou vencida
        // Você precisará definir as cores no seu colors.xml (ex: paid_color, unpaid_color)
        // e usá-las aqui. Por simplicidade, vou usar cores hardcoded como exemplo.
        if (expense.isPaid()) {
            holder.tvItemAmount.setTextColor(holder.itemView.getContext().getResources().getColor(R.color.md_theme_primary, holder.itemView.getContext().getTheme())); // Verde para pago
            // Se você tiver um ícone de status de pago, você o tornaria visível aqui
            // holder.ivPaidStatus.setVisibility(View.VISIBLE);
        } else {
            // Supondo que você queira vermelho para não pago (ou a cor padrão da descrição)
            holder.tvItemAmount.setTextColor(holder.itemView.getContext().getResources().getColor(R.color.md_theme_error, holder.itemView.getContext().getTheme())); // Vermelho para não pago
            // holder.ivPaidStatus.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return expenseList.size();
    }

    /**
     * ViewHolder para os itens da lista de despesas.
     * Contém as referências aos TextViews do layout item_expense.xml.
     */
    public static class ExpenseViewHolder extends RecyclerView.ViewHolder {
        TextView tvItemDescription;
        TextView tvItemAmount;
        TextView tvItemDueDate;
        // ImageView ivPaidStatus; // Se você adicionar um ImageView para o status de pago

        public ExpenseViewHolder(@NonNull View itemView) {
            super(itemView);
            tvItemDescription = itemView.findViewById(R.id.tvItemDescription);
            tvItemAmount = itemView.findViewById(R.id.tvItemAmount);
            tvItemDueDate = itemView.findViewById(R.id.tvItemDueDate);
            // ivPaidStatus = itemView.findViewById(R.id.ivPaidStatus); // Inicialize seu ImageView aqui
        }
    }

    /**
     * Método para atualizar os dados do adaptador.
     * É recomendado usar este método para fornecer novos dados ao RecyclerView.
     *
     * @param newExpenses A nova lista de objetos Expense.
     */
    public void updateExpenses(List<Expense> newExpenses) {
        // Limpa a lista existente e adiciona todos os novos itens.
        // É uma abordagem simples, mas para grandes listas, considere DiffUtil para melhor performance.
        this.expenseList.clear();
        if (newExpenses != null) {
            this.expenseList.addAll(newExpenses);
        }
        notifyDataSetChanged(); // Notifica o RecyclerView que os dados foram alterados
    }
}