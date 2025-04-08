package com.example.buddycart;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class GroupAddActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_add);

        // Set up Cancel button to close the activity.
        Button cancelGroupButton = findViewById(R.id.cancelGroupButton);
        cancelGroupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


        // container that will display the selected group members.
        final LinearLayout groupMembersContainer = findViewById(R.id.groupMembersContainer);


        // Attach click listeners for contacts.

        // For "Julian"
        Button addButtonJulian = findViewById(R.id.addButtonJulian);
        addButtonJulian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addMemberToGroup("Julian", groupMembersContainer);
                // Change button to indicate the contact has been added.
                addButtonJulian.setEnabled(false);
                addButtonJulian.setText("Added");
            }
        });

        // For "Greg"
        Button addButtonGreg = findViewById(R.id.addButtonGreg);
        addButtonGreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addMemberToGroup("Greg", groupMembersContainer);
                addButtonGreg.setEnabled(false);
                addButtonGreg.setText("Added");
            }
        });

        // For "Michael"
        Button addButtonMichael = findViewById(R.id.addButtonMichael);
        addButtonMichael.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addMemberToGroup("Michael", groupMembersContainer);
                addButtonMichael.setEnabled(false);
                addButtonMichael.setText("Added");
            }
        });

        // For "Samantha"
        Button addButtonSamantha = findViewById(R.id.addButtonSamantha);
        addButtonSamantha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addMemberToGroup("Samantha", groupMembersContainer);
                addButtonSamantha.setEnabled(false);
                addButtonSamantha.setText("Added");
            }
        });

        // For "Taylor"
        Button addButtonTaylor = findViewById(R.id.addButtonTaylor);
        addButtonTaylor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addMemberToGroup("Taylor", groupMembersContainer);
                addButtonTaylor.setEnabled(false);
                addButtonTaylor.setText("Added");
            }
        });

        // Set up Edit Group button functionality.
        Button editGroupButton = findViewById(R.id.editGroupButton);
        editGroupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Rename the Group
                final TextView groupTitle = findViewById(R.id.groupTitle);
                AlertDialog.Builder renameBuilder = new AlertDialog.Builder(GroupAddActivity.this);
                renameBuilder.setTitle("Edit Group Name");

                // Create an EditText prepopulated with the current group name.
                final EditText renameInput = new EditText(GroupAddActivity.this);
                renameInput.setHint("Enter new group name");
                renameInput.setText(groupTitle.getText());
                renameBuilder.setView(renameInput);

                renameBuilder.setPositiveButton("Rename", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String newName = renameInput.getText().toString().trim();
                        if (!newName.isEmpty()) {
                            groupTitle.setText(newName);
                            Toast.makeText(GroupAddActivity.this, "Group name updated!", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(GroupAddActivity.this, "Group name cannot be empty", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                renameBuilder.setNegativeButton("Cancel", null);
                renameBuilder.show();

                // Enable removal of added members
                // attach a long-click listener to each member view in the container.
                for (int i = 0; i < groupMembersContainer.getChildCount(); i++) {
                    final View memberView = groupMembersContainer.getChildAt(i);
                    memberView.setOnLongClickListener(new View.OnLongClickListener() {
                        @Override
                        public boolean onLongClick(View v) {
                            AlertDialog.Builder removeBuilder = new AlertDialog.Builder(GroupAddActivity.this);
                            removeBuilder.setTitle("Remove Member");
                            removeBuilder.setMessage("Do you want to remove this member?");
                            removeBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    groupMembersContainer.removeView(memberView);
                                    String removedName = ((TextView) memberView).getText().toString();

                                    // Reset the corresponding add button based on the member name.
                                    if (removedName.equalsIgnoreCase("Julian")) {
                                        Button addButtonJulian = findViewById(R.id.addButtonJulian);
                                        addButtonJulian.setEnabled(true);
                                        addButtonJulian.setText("Add");
                                    } else if (removedName.equalsIgnoreCase("Greg")) {
                                        Button addButtonGreg = findViewById(R.id.addButtonGreg);
                                        addButtonGreg.setEnabled(true);
                                        addButtonGreg.setText("Add");
                                    } else if (removedName.equalsIgnoreCase("Michael")){
                                        Button addButtonMichael = findViewById(R.id.addButtonMichael);
                                        addButtonMichael.setEnabled(true);
                                        addButtonMichael.setText("Add");
                                    } else if (removedName.equalsIgnoreCase("Samantha")){
                                        Button addButtonSamantha = findViewById(R.id.addButtonSamantha);
                                        addButtonSamantha.setEnabled(true);
                                        addButtonSamantha.setText("Add");
                                    } else if (removedName.equalsIgnoreCase("Taylor")){
                                        Button addButtonTaylor = findViewById(R.id.addButtonTaylor);
                                        addButtonTaylor.setEnabled(true);
                                        addButtonTaylor.setText("Add");
                                    }
                                    Toast.makeText(GroupAddActivity.this, "Member removed", Toast.LENGTH_SHORT).show();
                                }
                            });
                            removeBuilder.setNegativeButton("No", null);
                            removeBuilder.show();
                            return true;
                        }
                    });
                }
            }
        });

        // Set up bottom navigation:

        ImageButton houseImageButton = findViewById(R.id.houseImageButton);
        houseImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(GroupAddActivity.this, shoppingPage.class));
                finish();
            }
        });

        ImageButton mapImageButton = findViewById(R.id.mapImageButton);
        mapImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Example: navigate to Map activity.
                startActivity(new Intent(GroupAddActivity.this, Map.class));
            }
        });

        ImageButton cartImageButton = findViewById(R.id.cartImageButton);
        cartImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(GroupAddActivity.this, CheckoutScreen.class));
            }
        });

        ImageButton bellImageButton = findViewById(R.id.bellimageButton);
        bellImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(GroupAddActivity.this, Contacts.class));
            }
        });

        ImageButton personImageButton = findViewById(R.id.personImageButton);
        personImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
    /**
     * Helper method to add a new member to the group.
     *
     * @param name      The name of the member to add.
     * @param container The LinearLayout container that will hold the group members.
     */
    private void addMemberToGroup(String name, LinearLayout container) {
        // Create a new TextView to represent the new group member.
        TextView memberTextView = new TextView(this);
        memberTextView.setText(name);
        memberTextView.setTextSize(16);
        memberTextView.setPadding(8, 8, 8, 8);
        container.addView(memberTextView);
        Toast.makeText(this, name + " added to the group", Toast.LENGTH_SHORT).show();
    }
}
