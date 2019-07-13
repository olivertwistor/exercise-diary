<?php
defined('BASEPATH') OR exit('No direct script access allowed');

/**
 * Performs database migrations between different versions, as defined in
 * migration scripts in the migration folder.
 *
 * @author Johan Nilsson
 * @since 0.1.0
 */
class Migrate_database extends MY_Controller
{
    public function __construct()
    {
        parent::__construct();

        $this->load->library('migration');
    }

    /**
     * Tries to migrate the database to the version defined in configuration.
     * Presents the user with the result. Also logs it.
     *
     * @since 0.1.0
     */
    public function index()
    {
        // The view to show after the migration. Defaults to success, but
        // changes to failure if migration was unsuccessful.
        $view_file = 'success';

        // Try to migrate to that version.
        $result = $this->migration->current();

        if ($result === true)
        {
            log_message('debug',
                'Tried to migrate the database, but it was already at the ' .
                'desired version.'
            );
        }
        else if ($result === false)
        {
            log_message('error',
                'Failed to migrate the database. Error message: ' .
                $this->migration->error_string()
            );

            $view_file = 'failure';
        }
        else
        {
            log_message('debug',
                "Successfully migrated the database to version $result."
            );
        }

        // Render the view.
        $this->render_view("migration/$view_file");
    }
}
