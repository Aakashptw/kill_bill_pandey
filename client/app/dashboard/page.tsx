'use client'

import { RequireAuth } from "@/components/providers/require-auth";
import { AppShell } from "@/components/layout/app-shell";
// import { RepoDashboard } from "@/components/dashboard/repo-dashboard";

export default function DashboardPage() {
  return (
    <RequireAuth>
      <AppShell hideHeader>
        {/* <RepoDashboard/> */}
        <div className="flex min-h-svh items-center justify-center">
            <h1 className="text-2x1 font-bold">Welcome to AiProject</h1>
        </div>
      </AppShell>
    </RequireAuth>
  );
}
